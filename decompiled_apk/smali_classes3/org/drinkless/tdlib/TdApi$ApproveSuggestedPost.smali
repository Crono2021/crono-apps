.class public Lorg/drinkless/tdlib/TdApi$ApproveSuggestedPost;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ApproveSuggestedPost"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x371f7022


# instance fields
.field public chatId:J

.field public messageId:J

.field public sendDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35684
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35685
    return-void
.end method

.method public constructor <init>(JJI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I

    .line 35673
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35674
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ApproveSuggestedPost;->chatId:J

    .line 35675
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ApproveSuggestedPost;->messageId:J

    .line 35676
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ApproveSuggestedPost;->sendDate:I

    .line 35677
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35681
    const v0, -0x371f7022

    return v0
.end method
