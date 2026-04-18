.class public Lorg/drinkless/tdlib/TdApi$ChatListFolder;
.super Lorg/drinkless/tdlib/TdApi$ChatList;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatListFolder"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x16fe3e58


# instance fields
.field public chatFolderId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10212
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatList;-><init>()V

    .line 10213
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 10203
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatList;-><init>()V

    .line 10204
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatListFolder;->chatFolderId:I

    .line 10205
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10209
    const v0, 0x16fe3e58

    return v0
.end method
