.class public Lorg/drinkless/tdlib/TdApi$ChatMemberStatusBanned;
.super Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatMemberStatusBanned"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x628eb14a


# instance fields
.field public bannedUntilDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10248
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;-><init>()V

    .line 10249
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 10239
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;-><init>()V

    .line 10240
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatMemberStatusBanned;->bannedUntilDate:I

    .line 10241
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10245
    const v0, -0x628eb14a

    return v0
.end method
