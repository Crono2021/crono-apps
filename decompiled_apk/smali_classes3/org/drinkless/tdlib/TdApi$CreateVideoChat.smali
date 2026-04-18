.class public Lorg/drinkless/tdlib/TdApi$CreateVideoChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateVideoChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GroupCallId;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7ea4958d


# instance fields
.field public chatId:J

.field public isRtmpStream:Z

.field public startDate:I

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42966
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42967
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;IZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "i9"    # I
    .param p5, "z8"    # Z

    .line 42954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42955
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CreateVideoChat;->chatId:J

    .line 42956
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CreateVideoChat;->title:Ljava/lang/String;

    .line 42957
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$CreateVideoChat;->startDate:I

    .line 42958
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$CreateVideoChat;->isRtmpStream:Z

    .line 42959
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42963
    const v0, 0x7ea4958d

    return v0
.end method
