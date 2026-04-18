.class public Lorg/drinkless/tdlib/TdApi$ChatMemberStatusLeft;
.super Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatMemberStatusLeft"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x58bbdb


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1200
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 1205
    const v0, -0x58bbdb

    return v0
.end method
