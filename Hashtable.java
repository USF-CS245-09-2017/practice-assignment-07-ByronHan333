
public class Hashtable {
	private Node[] arr;
	public Hashtable(){
		arr = new Node[314527];
	}
	
	public boolean contains (String key){
		int pos = Math.abs(key.hashCode()%314527);
		boolean result = false;
		Node temp;
		while (arr[pos].hasNext()){
			temp = arr[pos].next;
			if(temp.key.equals(key)){
				result = true;
			}
		}
		return result;
	}
	
	public String get (String key){
		int pos = Math.abs(key.hashCode()%314527);
		String result = null;
		Node temp;
		while (arr[pos].hasNext()){
			temp = arr[pos].next;
			if(temp.key.equals(key)){
				result = temp.value;
			}
		}
		return result;
	}
	
	public void put (String key, String value){
		int pos = Math.abs(key.hashCode()%314527);
		if (arr[pos]==null){
			arr[pos] = new Node(key,value);
		}else{
			Node n = new Node(key,value);
			n.next = arr[pos];
			arr[pos] = n;
		}
	}
	
	//not done
	public String remove (String key){
		int pos = Math.abs(key.hashCode()%314527);
		String result = null;
		Node temp;
		if  (arr[pos].key.equals(key)){
			result = arr[pos].value;
		}else{
			while (arr[pos].hasNext()){
				temp = arr[pos].next;
				if(temp.hasNext() && temp.next.key.equals(key)){
					result = temp.next.value;
					temp.next = temp.next.next;
				}
			}
		}
		return result;
		
	}
	
	private class Node{
		private String key;
		private String value;
		private Node next;
		
		public Node(String key, String value){
			this.key = key;
			this.value = value;
			next = null;
		}
		
		public boolean hasNext(){
			if(next==null){
				return false;
			}else{
				return true;
			}
		}
		
		
		
	}
}
