let basket = {
	cartCount : 0,
	cartTotal : 0,
	cartList : function() {
		//fetch, $.ajax  <= petSHop 참조
		//템플릿리터럴(``)을  이용하거나  cloneNode()로 노드를 복사해서 append
		fetch("../cartSelectList")
		.then(response => response.json())
		.then(makeList);
	}
	,
	makeList : function(result){
		let basket = document.querySelector("#basket");
		let cartTemplate = document.querySelector("#template");
		for(i=0;i<result.length;i++){
			
		}
	},
	delItem    : function() {
		let no = "_________" 
		let url = "../cartDelete?no=" + no;	
		fetch(url).then(
			//선택한 버튼의 상품을 삭제.. 버튼.closet(".row").remove();
			this.reCalc();
		)
	},
	reCalc: function(){	
		//수량, 금액 합계 계산
		//합계 자리에 출력
	},
	changePNum : function() {	
			this.reCalc();
	}
	,
	delCheckedItem : function(){ 
			this.reCalc();
	},
	delAllItem : function() {	
			this.reCalc();
	},
};
basket.cartList();	
