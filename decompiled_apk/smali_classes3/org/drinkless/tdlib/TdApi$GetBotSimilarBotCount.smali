.class public Lorg/drinkless/tdlib/TdApi$GetBotSimilarBotCount;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBotSimilarBotCount"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Count;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4bca3e19


# instance fields
.field public botUserId:J

.field public returnLocal:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25764
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25765
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 25754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25755
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetBotSimilarBotCount;->botUserId:J

    .line 25756
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$GetBotSimilarBotCount;->returnLocal:Z

    .line 25757
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25761
    const v0, -0x4bca3e19

    return v0
.end method
