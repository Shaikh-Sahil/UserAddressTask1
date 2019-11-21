package com.example.demo.entities;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="ADDRESS")
public class Address
{
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer address_id;
    private String city;
    
//    @ManyToOne
//    @JsonIgnore
//    private Users user;
 



	    

}