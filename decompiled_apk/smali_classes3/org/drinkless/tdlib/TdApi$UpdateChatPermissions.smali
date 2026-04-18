.class public Lorg/drinkless/tdlib/TdApi$UpdateChatPermissions;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatPermissions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x60ade893


# instance fields
.field public chatId:J

.field public permissions:Lorg/drinkless/tdlib/TdApi$ChatPermissions;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34208
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34209
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatPermissions;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatPermissions"    # Lorg/drinkless/tdlib/TdApi$ChatPermissions;

    .line 34198
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34199
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatPermissions;->chatId:J

    .line 34200
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatPermissions;->permissions:Lorg/drinkless/tdlib/TdApi$ChatPermissions;

    .line 34201
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34205
    const v0, -0x60ade893

    return v0
.end method
