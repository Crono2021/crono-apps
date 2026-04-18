.class public Lorg/drinkless/tdlib/TdApi$ChatMembersFilterBanned;
.super Lorg/drinkless/tdlib/TdApi$ChatMembersFilter;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatMembersFilterBanned"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6f0cb0b8


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1232
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMembersFilter;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 1237
    const v0, -0x6f0cb0b8

    return v0
.end method
