package test;

/**
 * 房间服务，这个房间服务主要功能为管理房间以及房间内的成员（String 类型）。
 * 如果房间不存在则创建这个房间
 *
 * 保证并**况下的房间用户数据一致性
 */
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
interface RoomService {

	void joinRoom(String userId, String roomId) throws RuntimeException;
	
	void leaveRoom(String userId, String roomId) throws RuntimeException;

	Collection<String> queryUser(String roomId) throws RuntimeException;
}

class RoomServiceImp implements RoomService {
	
	private ConcurrentHashMap<String, HashSet<String>> hotel = new ConcurrentHashMap<String, HashSet<String>>();
	@Override
	public void joinRoom(String userId, String roomId) throws RuntimeException {
		
		HashSet<String> room = hotel.get(roomId);
		if(room == null) {
			room = new HashSet<String>();
		}
		room.add(userId);
		hotel.put(roomId, room);
	}

	@Override
	public void leaveRoom(String userId, String roomId) throws RuntimeException {
		
		HashSet<String> room = hotel.get(roomId);
		if(room != null) {
			room.remove(userId);
		}
		
	}

	@Override
	public Collection<String> queryUser(String roomId) throws RuntimeException {
		HashSet<String> room = hotel.get(roomId);
		return room;
	}
	
}

public class test3 {
	

}
