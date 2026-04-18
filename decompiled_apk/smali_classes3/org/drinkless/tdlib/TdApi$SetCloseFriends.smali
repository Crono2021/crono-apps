.class public Lorg/drinkless/tdlib/TdApi$SetCloseFriends;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetCloseFriends"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x71b9f8ca


# instance fields
.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19590
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19591
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 19581
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19582
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetCloseFriends;->userIds:[J

    .line 19583
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19587
    const v0, -0x71b9f8ca

    return v0
.end method
