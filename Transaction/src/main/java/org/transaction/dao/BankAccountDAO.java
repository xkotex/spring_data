package org.transaction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.transaction.entity.BankAccount;
import org.transaction.exception.BankTransactionException;
import org.transaction.model.BankAccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BankAccountDAO {

	@Autowired
	private EntityManager entityManager;
	
	public BankAccountDAO(){
		
	}
	
	public BankAccount findById(Long id){
		return this.entityManager.find(BankAccount.class, id);
	}
	
	public List<BankAccountInfo> listBankAccountInfo(){
		String sql = "Select new " + BankAccountInfo.class.getName() + "(e.id,e.fullName,e.balance) from " + BankAccount.class.getName() + " e ";
		Query query = this.entityManager.createQuery(sql, BankAccountInfo.class);
		return query.getResultList();
	}
	
	public void addAmount(Long id, double amount) throws BankTransactionException {
		BankAccount account = this.findById(id);
		if (account == null){
			throw new BankTransactionException("Account not found "+ id);
		}
		double newBalance = account.getBalance() + amount;
		if (account.getBalance() + amount < 0){
			throw new BankTransactionException("The money in the account '" + id +"' is not enough (" + account.getBalance() + ")");
		}
		account.setBalance(newBalance);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = BankTransactionException.class)
	public void sendMoney(Long fromAccount, Long toAccount, double amount) throws BankTransactionException{
		addAmount(fromAccount, -amount);
		addAmount(toAccount, amount);
	}
}
