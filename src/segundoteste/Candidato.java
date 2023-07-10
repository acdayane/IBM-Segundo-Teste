package segundoteste;

public class Candidato {
    int id;
    String name;
    String status;

    public Candidato(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.name;
    }

    public void setStatus(String status) {
		this.status = status;
	}

    public String getStatus() {
		return this.status;
	}
}
