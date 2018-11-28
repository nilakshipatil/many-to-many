package demo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="Events")
public class Event {
	@Id
	private String eventid;
	private String desc;
	private Date eventdate;
	
	@ManyToMany()
	private Set<Person> attendees = new HashSet<Person>();
	
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getEventdate() {
		return eventdate;
	}
	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}
	@Override
	public String toString() {
		return "Event [eventid=" + eventid + ", desc=" + desc + ", eventdate=" + eventdate + "]";
	}
	public Set<Person> getAttendees() {
		return attendees;
	}
	public void setAttendees(Set<Person> attendees) {
		this.attendees = attendees;
	}
	
}
