.class public Lorg/drinkless/tdlib/TdApi$GetChatBoostLevelFeatures;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatBoostLevelFeatures"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatBoostLevelFeatures;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x45e63e8b


# instance fields
.field public isChannel:Z

.field public level:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25784
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25785
    return-void
.end method

.method public constructor <init>(ZI)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "i9"    # I

    .line 25774
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25775
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatBoostLevelFeatures;->isChannel:Z

    .line 25776
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$GetChatBoostLevelFeatures;->level:I

    .line 25777
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25781
    const v0, 0x45e63e8b

    return v0
.end method
