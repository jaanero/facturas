package jaanero.facturas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NOTE")
public class Note {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "NOTE_KEY")
   private Long id;
   @Column(name = "NOTE_NAME")
   private String name;
   @Column(name = "NOTE_TEXT")
   private String text;

   public Note(String noteName, String noteText) {
      this.name = noteName;
      this.text = noteText;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

}
