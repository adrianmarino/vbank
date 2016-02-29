package com.nonosoft.vbank.env;

public class MissingVBankEnvironmentException extends RuntimeException {
  public MissingVBankEnvironmentException() {
    super("Missing environment value. Try use any of next (case insensitive) values:" +
        " env=[ \"dev\" | \"test\" | \"prod\" ]");
  }
}
