# Hibernate Test Case
Ordinarily reproducers use h2 in memory database. However, this issue does not reproduce with h2, so it is necessary to use mysql via docker-compose. To run these tests, execute these commands:
```bash
docker-compose up  
./ci/build.sh
```

You will notice that the test passes in Hibernate 5, but fails in Hibernate 6