.class public Lorg/drinkless/tdlib/TdApi$UpdateChatActionBar;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatActionBar"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x265da73e


# instance fields
.field public actionBar:Lorg/drinkless/tdlib/TdApi$ChatActionBar;

.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33848
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33849
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatActionBar;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatActionBar"    # Lorg/drinkless/tdlib/TdApi$ChatActionBar;

    .line 33838
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33839
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatActionBar;->chatId:J

    .line 33840
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatActionBar;->actionBar:Lorg/drinkless/tdlib/TdApi$ChatActionBar;

    .line 33841
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33845
    const v0, -0x265da73e

    return v0
.end method
