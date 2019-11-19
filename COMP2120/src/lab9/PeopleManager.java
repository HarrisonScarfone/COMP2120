package lab9;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeopleManager {

		public final String filepath;		
		public ArrayList<Person> people;
		
		public PeopleManager() {
			people = new ArrayList<Person>();
			this.filepath = "records.txt";
			loadRecords();
		}

		public void writeRecords(){

			File outFile = new File(filepath);

			try	{
				FileWriter fw = new FileWriter(outFile, false);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				for(Person p: people) {
					pw.println(p);
				}
				pw.flush();
				pw.close();
			}catch(Exception e){
				System.out.println("Error");
				e.printStackTrace();
			}
		}
		
		public void loadRecords() {
			
			Scanner scanner = null;
			String nextLine;
			
			File inFile = new File(filepath);
			String pattern = "(.+),(.+),(.+)/(.+)/(.+)";
			Pattern p = Pattern.compile(pattern);
			Matcher m;
			
			try {
				scanner = new Scanner(inFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			people.clear();
			
			while(scanner.hasNextLine()) {
				nextLine = scanner.nextLine();
				m = p.matcher(nextLine);
				if(m.find()) {
					String fn = m.group(1);
					String ln = m.group(2);
					String month = m.group(3);
					String day = m.group(4);
					String year = m.group(5);
					people.add(new Person(fn, ln, month, day, year));
				}else {			
					System.out.println("couldnt add a person");
				}
			}
			sortPeopleDescending();		
		}
		
		public ArrayList<Person> getPeople() {
			return people;
		}
		
		public void setPeople(ArrayList<Person> people) {
			this.people = people;
		}
		
		public void sortPeopleDescending() {
			Collections.sort(people, new DescendingPeopleSort());
		}
		
		public void sortPeopleAscending() {
			Collections.sort(people, new AscendingPeopleSort());
		}
		
		public void addPerson(Person p) {
			people.add(p);
		}
		
		public void removePerson(int index) {
			people.remove(index);
		}
		
		public void clearPeople() {
			people.clear();
		}
}
