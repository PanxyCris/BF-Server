//闇�瑕佸鎴风鐨凷tub
package service;

import java.rmi.Remote;

import java.rmi.RemoteException;

public interface UserService extends Remote{
	public boolean login(String username, String password) throws RemoteException;

	public boolean logout(String username) throws RemoteException;

	public boolean register(String username, String password) throws RemoteException;

	public void store(String username) throws RemoteException;

	public void storedocument(String information) throws RemoteException;

	
}
