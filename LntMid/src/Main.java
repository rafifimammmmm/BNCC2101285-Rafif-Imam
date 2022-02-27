import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
Scanner scan = new Scanner(System.in);
Random rand = new Random();
Vector<String> vKode = new Vector<String>();
Vector<String> vNama = new Vector<String>();
Vector<String> vRole = new Vector<String>();
Vector<String> vGender = new Vector<String>();
Vector<Integer> vGaji = new Vector<Integer>();


	public Main() {
		int menu=0;
	do {	
		System.out.println("PU Musang");
		System.out.println("=========");
		System.out.println("1. Insert Data");
		System.out.println("2. View Data");
		System.out.println("3. Update Data");
		System.out.println("4. Delete Data");
		System.out.print(">> ");
		menu = p();
		
		switch(menu) {
		case 1 :
			insert();
			break;
		case 2 :
			view();
			break;
		case 3 :
			update();
			break;
		case 4 :
			delete();
			break;
		
		}
		
	}while(menu != 5);
		
	}
	
	private void delete() {
		if(vKode.isEmpty()) {
			System.out.println("Tidak ada karyawan!");
			
		}
		for(int i=0; i < vNama.size()-1; i++){
			for(int j=i+1; j<vNama.size();j++) {
				if(vNama.get(i).compareTo(vNama.get(j))>0){
					swap(i,j);	
				}
			
			}
		}
		for(int i = 0; i < vKode.size(); i++) {
			System.out.println("No. " + (i+1));
			System.out.println("ID      : " + vKode.get(i));
			System.out.println("Nama    : " + vNama.get(i));				
			System.out.println("Gender  : " + vGender.get(i));
			System.out.println("Jabatan : " + vRole.get(i));
			System.out.println("Gaji    : " + vGaji.get(i));
		}
		
		int idx = -1;
		do {
			System.out.print("Input index [1.." + vKode.size() +"] to remove : ");
			idx = p();
			idx --;
		}while(idx < 0 || idx >= vKode.size());
		
		vNama.remove(idx);
		vGender.remove(idx);
		vRole.remove(idx);
		vGaji.remove(idx);
		vKode.remove(idx);
		
		System.out.println("Karyawan Berhasil Di hapus!");
		
	}

	private void update() {
		if(vKode.isEmpty()) {
			System.out.println("Tidak ada karyawan!");
			
		}
		for(int i=0; i < vNama.size()-1; i++){
			for(int j=i+1; j<vNama.size();j++) {
				if(vNama.get(i).compareTo(vNama.get(j))>0){
					swap(i,j);	
				}
			
			}
		}
		for(int i = 0; i < vKode.size(); i++) {
			System.out.println("No. " + (i+1));
			System.out.println("ID      : " + vKode.get(i));
			System.out.println("Nama    : " + vNama.get(i));				
			System.out.println("Gender  : " + vGender.get(i));
			System.out.println("Jabatan : " + vRole.get(i));
			System.out.println("Gaji    : " + vGaji.get(i));
		}
		
		int idx = -1;
		do {
			System.out.print("Input index [1.." + vKode.size() +"] to update : ");
			idx = p();
			idx --;
		}while(idx < 0 || idx >= vKode.size());
		
		String kode,nama,gender,role;
		int gaji;
		
		do {
			System.out.print("Input nama karyawan : ");
			nama = scan.nextLine();
		}while(nama.length() < 3);
		
		do {
			System.out.print("Jenis Kelamin [Laki-laki || Perempuan] : ");
			gender = scan.nextLine();
			
		}while(!(gender.equals("Laki-laki") || gender.equals("Perempuan")));
		
		do {
			System.out.print("Input Jabatan [Manager || Supervisor || Admin] : ");
			role = scan.nextLine();
		}while(!(role.equals("Manager") || role.equals("Supervisor") || role.equals("Admin")));
		
		if(role == "Manager") {
			gaji = 8000000;
		}if(role == "Supervisor") {
			gaji = 6000000;
		}else {
			gaji = 4000000;
		}
		
		kode="";
		kode = kode + (char) (rand.nextInt(26) + 'A') + (char) (rand.nextInt(26) + 'A') + ((char)makeRandom('0','9')) + ((char)makeRandom('0','9')) + ((char)makeRandom('0','9')) + ((char)makeRandom('0','9'));
		
		System.out.println("Berhasil Menambahkan Karyawan dengan ID : " + kode);
		System.out.println("Enter to return");
		System.out.println();
		
		vNama.set(idx,nama);
		vGender.set(idx,gender);
		vRole.set(idx,role);
		vGaji.set(idx,gaji);
		vKode.set(idx,kode);
		
		System.out.println(" Data Karyawan Berhasil di update");
		
	}

	private void view() {
		if(vKode.isEmpty()) {
			System.out.println("Tidak ada karyawan!");
			
		}
		for(int i=0; i < vNama.size()-1; i++){
			for(int j=i+1; j<vNama.size();j++) {
				if(vNama.get(i).compareTo(vNama.get(j))>0){
					swap(i,j);	
				}
			
			}
		}
		for(int i = 0; i < vKode.size(); i++) {
			System.out.println("No. " + (i+1));
			System.out.println("ID      : " + vKode.get(i));
			System.out.println("Nama    : " + vNama.get(i));				
			System.out.println("Gender  : " + vGender.get(i));
			System.out.println("Jabatan : " + vRole.get(i));
			System.out.println("Gaji    : " + vGaji.get(i));
		}
		
		
		
	}

	private void swap(int i, int j) {
		String temp = vKode.get(i);
		vKode.set(i, vKode.get(j));
		vKode.set(j, temp);
		
		temp = vNama.get(i);
		vNama.set(i, vNama.get(j));
		vNama.set(j, temp);
		
		 temp = vGender.get(i);
		vGender.set(i, vGender.get(j));
		vGender.set(j, temp);
		
		 temp = vRole.get(i);
			vRole.set(i, vRole.get(j));
			vRole.set(j, temp);
		
		int t = vGaji.get(i);
		vGaji.set(i, vGaji.get(j));
		vGaji.set(j, t);
		
		
	}
		
	

	private void insert() {
		String kode,nama,gender,role;
		int gaji;
		
		do {
			System.out.print("Input nama karyawan : ");
			nama = scan.nextLine();
		}while(nama.length() < 3);
		
		do {
			System.out.print("Jenis Kelamin [Laki-laki || Perempuan] : ");
			gender = scan.nextLine();
			
		}while(!(gender.equals("Laki-laki") || gender.equals("Perempuan")));
		
		do {
			System.out.print("Input Jabatan [Manager || Supervisor || Admin] : ");
			role = scan.nextLine();
		}while(!(role.equals("Manager") || role.equals("Supervisor") || role.equals("Admin")));
		
		if(role == "Manager") {
			gaji = 8000000;
		}if(role == "Supervisor") {
			gaji = 6000000;
		}else {
			gaji = 4000000;
		}
		
		kode="";
		kode = kode + (char) (rand.nextInt(26) + 'A') + (char) (rand.nextInt(26) + 'A') + ((char)makeRandom('0','9')) + ((char)makeRandom('0','9')) + ((char)makeRandom('0','9')) + ((char)makeRandom('0','9'));
		
		System.out.println("Berhasil Menambahkan Karyawan dengan ID : " + kode);
		System.out.println("Enter to return");
		System.out.println();
		
		vNama.add(nama);
		vGender.add(gender);
		vRole.add(role);
		vGaji.add(gaji);
		vKode.add(kode);
		
	}
	
	
	 
	int makeRandom(int min, int max) {
		return rand.nextInt(max - min  + 1) + min;
	}

	private int p() {
		int a;
		try {
			a = scan.nextInt();
		} catch (Exception e) {
			a=-1;
		}
		scan.nextLine();
		return a;
		
	}

	public static void main(String[] args) {
		new Main();

	}

}
