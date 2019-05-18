package com.kscory.weeklybook.data

import com.kscory.weeklybook.domain.gateway.BookGateway
import com.kscory.weeklybook.model.Recommendation
import io.reactivex.Single

class BookGatewayImpl: BookGateway {

    override fun getBookRecommended(): Single<Recommendation> {

        val rec = Recommendation(1,
            "[ 사회, 연대, 그리고 집단의 힘 ]",
            "오늘도 다른 사람들과 함께 살아가는 '우리'",
            "갈등과 혐오를 벗어나 좀 더 건전한 방향은 없을까?\n그리고 과연 인간집단은 이 난관을 이겨낼 수 있을까?",
            "여기 두 저명한 일본인의 글을 모아봤습니다.",
            "_무라카미 하루키 \u003C직업으로서 소설가\u003E\n_히사이시 조 \u003C감동을 만들 수 있습니까\u003E",
            "https://s3-ap-northeast-1.amazonaws.com/corytubes/tmepimage/test_1.jpeg",
            "https://s3-ap-northeast-1.amazonaws.com/corytubes/tmepimage/test_2.jpeg",
            "https://s3-ap-northeast-1.amazonaws.com/corytubes/tmepimage/test_3.jpeg",
            "https://s3-ap-northeast-1.amazonaws.com/corytubes/tmepimage/test_4.jpeg",
            "https://s3-ap-northeast-1.amazonaws.com/corytubes/tmepimage/test_5.jpeg",
            "https://s3-ap-northeast-1.amazonaws.com/corytubes/tmepimage/test_6.jpeg",
            false)

        return Single.just(rec)
    }

    override fun changeFavorite(id: Int, isFavorite: Boolean): Single<Boolean> {
        return Single.just(!isFavorite)
    }
}