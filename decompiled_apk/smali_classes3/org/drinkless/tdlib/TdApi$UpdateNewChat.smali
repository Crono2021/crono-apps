.class public Lorg/drinkless/tdlib/TdApi$UpdateNewChat;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7bb98ccd


# instance fields
.field public chat:Lorg/drinkless/tdlib/TdApi$Chat;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21854
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21855
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Chat;)V
    .locals 0
    .param p1, "chat"    # Lorg/drinkless/tdlib/TdApi$Chat;

    .line 21845
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21846
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewChat;->chat:Lorg/drinkless/tdlib/TdApi$Chat;

    .line 21847
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21851
    const v0, 0x7bb98ccd

    return v0
.end method
