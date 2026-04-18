.class public Lorg/drinkless/tdlib/TdApi$OpenBotSimilarBot;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OpenBotSimilarBot"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x16090128


# instance fields
.field public botUserId:J

.field public openedBotUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28884
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 28885
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 28874
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 28875
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$OpenBotSimilarBot;->botUserId:J

    .line 28876
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$OpenBotSimilarBot;->openedBotUserId:J

    .line 28877
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28881
    const v0, -0x16090128

    return v0
.end method
