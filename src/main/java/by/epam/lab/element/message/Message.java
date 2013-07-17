/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.element.message;

/**
 *
 * @author Alina_Shumel
 */
public class Message {
    
   private String addressee;
   private String subject;
   private String text;
   private String time;

    public Message() {
    }

   
   
    public Message(String addressee, String subject, String text, String time) {
        this.addressee = addressee;
        this.subject = subject;
        this.text = text;
        this.time = time;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.addressee != null ? this.addressee.hashCode() : 0);
        hash = 71 * hash + (this.subject != null ? this.subject.hashCode() : 0);
        hash = 71 * hash + (this.text != null ? this.text.hashCode() : 0);
        hash = 71 * hash + (this.time != null ? this.time.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Message other = (Message) obj;
        if ((this.addressee == null) ? (other.addressee != null) : !this.addressee.equals(other.addressee)) {
            return false;
        }
        if ((this.subject == null) ? (other.subject != null) : !this.subject.equals(other.subject)) {
            return false;
        }
        if ((this.text == null) ? (other.text != null) : !this.text.equals(other.text)) {
            return false;
        }
        if ((this.time == null) ? (other.time != null) : !this.time.equals(other.time)) {
            return false;
        }
        return true;
    }

    
    
    public boolean equalsContent(Object obj){
       if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Message other = (Message) obj;
        if ((this.addressee == null) ? (other.addressee != null) : !this.addressee.equals(other.addressee)) {
            return false;
        }
        if ((this.subject == null) ? (other.subject != null) : !this.subject.equals(other.subject)) {
            return false;
        }
        if ((this.text == null) ? (other.text != null) : !this.text.equals(other.text)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Message{" + "addressee=" + addressee + ", subject=" + subject + ", text=" + text + ", time=" + time + '}';
    }
   
   
   
    
}
