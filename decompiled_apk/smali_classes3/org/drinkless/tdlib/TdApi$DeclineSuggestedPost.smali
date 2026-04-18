.class public Lorg/drinkless/tdlib/TdApi$DeclineSuggestedPost;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeclineSuggestedPost"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x68cced81


# instance fields
.field public chatId:J

.field public comment:Ljava/lang/String;

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36542
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36543
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;

    .line 36531
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36532
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeclineSuggestedPost;->chatId:J

    .line 36533
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$DeclineSuggestedPost;->messageId:J

    .line 36534
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$DeclineSuggestedPost;->comment:Ljava/lang/String;

    .line 36535
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36539
    const v0, -0x68cced81

    return v0
.end method
