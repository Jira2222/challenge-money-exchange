package fabian.challenge.money.exchange.models;

public record Money(String base_code, String target_code, double conversion_rate) {
}
