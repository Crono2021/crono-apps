.class public Lorg/drinkless/tdlib/TdApi$GetMessagePublicForwards;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMessagePublicForwards"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PublicForwards;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x519da4b4


# instance fields
.field public chatId:J

.field public limit:I

.field public messageId:J

.field public offset:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43494
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43495
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "i9"    # I

    .line 43482
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43483
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMessagePublicForwards;->chatId:J

    .line 43484
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetMessagePublicForwards;->messageId:J

    .line 43485
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$GetMessagePublicForwards;->offset:Ljava/lang/String;

    .line 43486
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$GetMessagePublicForwards;->limit:I

    .line 43487
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43491
    const v0, 0x519da4b4

    return v0
.end method
