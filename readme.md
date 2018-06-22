# 프로젝트 개요
	* 첨부된 price.json을 읽어서 사용자에게 보여주는 api 서버를 개발하세요.
    * Spring Boot 2.0을 이용하세요.

# 거래 데이터 파일(price.json)
	* 각 코인별, 거래소별 시고저종 가격이 들어있는 데이터 입니다.
 	* ex) BTC_KRW.coinone.last = 7503000

# 요청 URL
	* http://localhost:8080/api/v1/data/currency/
    * http://localhost:8080/api/v1/data/currency/{currency}

# 요청 파라미터
    * currency : BTC | EOS | ETH | BCH | XRP
    * ex) http://localhost:8080/api/v1/data/currency/BTC 로 요청을 하면 BTC_KRW 가격만 반환됨
    * http://localhost:8080/api/v1/data/currency/ 이렇게 요청하면 전체 코인 가격이 반환됨
    

# 응답 (JSON)
parameter 없는 경우
```json
{
	'BTC_KRW':'종가',
	'ETH_KRW':'종가', 
	'EOS_KRW':'종가', 
	'BCH_KRW':'종가', 
	'XRP_KRW':'종가'
}
```

데이터에 있는 여러가지 코인중에 다섯가지만 보여주시면 됩니다.

parameter있는 경우
```json
{
	'BTC_KRW':'종가'
}
```



# 예제

### 요청

http://localhost:8080/api/v1/data/currency

### 응답
```json
{
	"status": "success",
	"data": {
		"BTC_KRW": {
			"bithumb": {
				"originPair": "BTCKRW",
				"last": 7471000.0
			},
			"coinone": {
				"originPair": "BTCKRW",
				"last": 7503000.0
			},
			"korbit": {
				"originPair": "BTCKRW",
				"last": 7524500.0
			},
			"bitfinex": null
		},
		"LTC_KRW": {
			"bithumb": {
				"originPair": "LTCKRW",
				"last": 107800.0
			},
			"coinone": {
				"originPair": "LTCKRW",
				"last": 108050.0
			},
			"korbit": null,
			"bitfinex": null
		},
		"EOS_KRW": {
			"bithumb": {
				"originPair": "EOSKRW",
				"last": 11600.0
			},
			"coinone": {
				"originPair": "EOSKRW",
				"last": 11640.0
			},
			"korbit": null,
			"bitfinex": null
		},
		"BCH_KRW": {
			"bithumb": {
				"originPair": "BCHKRW",
				"last": 973000.0
			},
			"coinone": {
				"originPair": "BCHKRW",
				"last": 976500.0
			},
			"korbit": {
				"originPair": "BCHKRW",
				"last": 980000.0
			},
			"bitfinex": null
		},
		"XRP_KRW": {
			"bithumb": {
				"originPair": "XRPKRW",
				"last": 594.0
			},
			"coinone": {
				"originPair": "XRPKRW",
				"last": 597.0
			},
			"korbit": {
				"originPair": "XRPKRW",
				"last": 600.0
			},
			"bitfinex": null
		},
		"ETH_KRW": {
			"bithumb": {
				"originPair": "ETHKRW",
				"last": 584000.0
			},
			"coinone": {
				"originPair": "ETHKRW",
				"last": 587000.0
			},
			"korbit": {
				"originPair": "ETHKRW",
				"last": 586600.0
			},
			"bitfinex": null
		}
	}
}
```
    


### 요청
	http://localhost:8080/api/v1/data/currency/LTC    

### 응답
```json
  {
	"status": "success",
	"data": {
		"bithumb": {
			"originPair": "LTCKRW",
			"last": 107800.0
		},
		"coinone": {
			"originPair": "LTCKRW",
			"last": 108050.0
		},
		"korbit": null,
		"bitfinex": null
	}
}
```
    
