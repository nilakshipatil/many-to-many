package demo;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	@Id
	private int pid;
	private String name;
	@ManyToMany(mappedBy="attendees")
	private Set<Event> commitments = new HashSet<Event>();
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + "]";
	}
	public Set<Event> getCommitments() {
		return commitments;
	}
	public void setCommitments(Set<Event> commitments) {
		this.commitments = commitments;
	}
	
	
	
}
