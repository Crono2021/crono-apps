.class public Lorg/drinkless/tdlib/TdApi$SetPinnedChats;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetPinnedChats"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x29769fc0


# instance fields
.field public chatIds:[J

.field public chatList:Lorg/drinkless/tdlib/TdApi$ChatList;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31708
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31709
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatList;[J)V
    .locals 0
    .param p1, "chatList"    # Lorg/drinkless/tdlib/TdApi$ChatList;
    .param p2, "jArr"    # [J

    .line 31698
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31699
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetPinnedChats;->chatList:Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 31700
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetPinnedChats;->chatIds:[J

    .line 31701
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31705
    const v0, -0x29769fc0

    return v0
.end method
