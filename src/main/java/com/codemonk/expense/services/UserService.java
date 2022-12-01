package com.codemonk.expense.services;

import com.codemonk.expense.domain.User;
import com.codemonk.expense.exceptions.EtAuthException;

import java.util.Date;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;

}
