.class public Lorg/drinkless/tdlib/TdApi$CreatePrivateChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreatePrivateChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chat;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x387da4f7


# instance fields
.field public force:Z

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24704
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24705
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 24694
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24695
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CreatePrivateChat;->userId:J

    .line 24696
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$CreatePrivateChat;->force:Z

    .line 24697
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24701
    const v0, -0x387da4f7

    return v0
.end method
