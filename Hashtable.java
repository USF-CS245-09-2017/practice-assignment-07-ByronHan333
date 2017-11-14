

public class Hashtable {
	private Node[] arr;
	public Hashtable(){
		arr = new Node[314527];
	}
	
	public boolean contains (String key){
		int pos = Math.abs(key.hashCode())%314527;
		boolean result = false;
		Node temp = arr[pos];
		while (temp!=null){
			if(temp.key.equals(key)){
				result = true;
				return result;
			}
			temp = temp.next;
		}
		return result;
	}
	
	public String get (String key){
		int pos = Math.abs(key.hashCode())%314527;
		String result = null;
		Node temp =arr[pos];	
		while (temp!=null){
			if(temp.key.equals(key)){
				result = temp.value;
				return result;
			}
			temp = temp.next;
		}
		return result;
	}
	
	
	public void put (String key, String value){
		int pos = Math.abs(key.hashCode())%314527;
		if (arr[pos]==null){
			arr[pos] = new Node(key,value);
		}else{
			Node temp = arr[pos];
			if (temp.key.equals(key)){
				arr[pos].value = value; 
			}
			while((temp.next!=null)&&(temp.next.key!=key)){
				temp = temp.next;
			}
			if(temp.next!=null){
				temp.next.value=value;
			}
			Node n = new Node(key,value);
			temp.next=n;
		}
	}
	
	/**
	throws exception
	*/
	

	public String remove (String key) throws Exception{
		int pos = Math.abs(key.hashCode())%314527;
		Node temp = arr[pos];	
		if (temp.key.equals(key)){
			arr[pos] = temp.next;
			return temp.value;
		}
		while ((temp.next!=null)&&(temp.next.key!=key)){
			temp=temp.next;
		}
		if(temp.next!= null){
			temp.next=temp.next.next;
			return temp.next.value;
		}
		{
			throw new Exception();
		}
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
		
		
		
		
	}
}
