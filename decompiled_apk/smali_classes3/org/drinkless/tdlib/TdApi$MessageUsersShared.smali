.class public Lorg/drinkless/tdlib/TdApi$MessageUsersShared;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageUsersShared"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3236a64e


# instance fields
.field public buttonId:I

.field public users:[Lorg/drinkless/tdlib/TdApi$SharedUser;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28724
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28725
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$SharedUser;I)V
    .locals 0
    .param p1, "sharedUserArr"    # [Lorg/drinkless/tdlib/TdApi$SharedUser;
    .param p2, "i9"    # I

    .line 28714
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28715
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageUsersShared;->users:[Lorg/drinkless/tdlib/TdApi$SharedUser;

    .line 28716
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$MessageUsersShared;->buttonId:I

    .line 28717
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28721
    const v0, -0x3236a64e

    return v0
.end method
