package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {


    public void saveAccount(BankAccount account, Path folder) {
        Path path = folder.resolve(account.getAccountNumber() + ".dat");
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(Files.newOutputStream(path)))) {
            dos.writeUTF(account.getAccountNumber());
            dos.writeUTF(account.getOwner());
            dos.writeDouble(account.getBalance());
        }
        catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    public BankAccount loadAccount(InputStream inputStream) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(inputStream))) {
            String accountNumber = dis.readUTF();
            String owner = dis.readUTF();
            double balance = dis.readDouble();
            return new BankAccount(accountNumber, owner, balance);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }
}
