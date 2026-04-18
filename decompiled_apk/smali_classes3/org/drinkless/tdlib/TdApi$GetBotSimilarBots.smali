.class public Lorg/drinkless/tdlib/TdApi$GetBotSimilarBots;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBotSimilarBots"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Users;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x312ea04b


# instance fields
.field public botUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12138
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12139
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 12129
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12130
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetBotSimilarBots;->botUserId:J

    .line 12131
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12135
    const v0, -0x312ea04b    # -1.7563552E9f

    return v0
.end method
