.class public Lorg/drinkless/tdlib/TdApi$FoundChatBoosts;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FoundChatBoosts"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3112e90


# instance fields
.field public boosts:[Lorg/drinkless/tdlib/TdApi$ChatBoost;

.field public nextOffset:Ljava/lang/String;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36982
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36983
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$ChatBoost;Ljava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "chatBoostArr"    # [Lorg/drinkless/tdlib/TdApi$ChatBoost;
    .param p3, "str"    # Ljava/lang/String;

    .line 36971
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36972
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$FoundChatBoosts;->totalCount:I

    .line 36973
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$FoundChatBoosts;->boosts:[Lorg/drinkless/tdlib/TdApi$ChatBoost;

    .line 36974
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$FoundChatBoosts;->nextOffset:Ljava/lang/String;

    .line 36975
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36979
    const v0, 0x3112e90

    return v0
.end method
