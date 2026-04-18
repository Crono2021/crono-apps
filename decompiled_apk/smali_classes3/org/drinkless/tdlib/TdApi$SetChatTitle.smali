.class public Lorg/drinkless/tdlib/TdApi$SetChatTitle;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatTitle"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x9cabebf


# instance fields
.field public chatId:J

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31468
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31469
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 31458
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31459
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatTitle;->chatId:J

    .line 31460
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatTitle;->title:Ljava/lang/String;

    .line 31461
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31465
    const v0, 0x9cabebf

    return v0
.end method
