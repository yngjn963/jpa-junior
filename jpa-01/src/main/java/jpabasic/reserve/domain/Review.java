package jpabasic.reserve.domain;

@Entity
public class Review {
    @Id
    @Column(name = "review_id)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "hotel_id")
    private String hotelId;

    public Review(int mark, String hotelId, String writerName, String comment) {
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }
}
