.class public Lorg/drinkless/tdlib/TdApi$AnswerWebAppQuery;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AnswerWebAppQuery"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$SentWebAppMessage;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5f4b630f


# instance fields
.field public result:Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;

.field public webAppQueryId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22884
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22885
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "inputInlineQueryResult"    # Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;

    .line 22874
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22875
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AnswerWebAppQuery;->webAppQueryId:Ljava/lang/String;

    .line 22876
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AnswerWebAppQuery;->result:Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;

    .line 22877
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22881
    const v0, -0x5f4b630f

    return v0
.end method
