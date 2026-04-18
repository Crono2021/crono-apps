.class public Lorg/drinkless/tdlib/TdApi$ViewMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ViewMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x393c0c70


# instance fields
.field public chatId:J

.field public forceRead:Z

.field public messageIds:[J

.field public source:Lorg/drinkless/tdlib/TdApi$MessageSource;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46422
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46423
    return-void
.end method

.method public constructor <init>(J[JLorg/drinkless/tdlib/TdApi$MessageSource;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "jArr"    # [J
    .param p4, "messageSource"    # Lorg/drinkless/tdlib/TdApi$MessageSource;
    .param p5, "z8"    # Z

    .line 46410
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46411
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ViewMessages;->chatId:J

    .line 46412
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ViewMessages;->messageIds:[J

    .line 46413
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ViewMessages;->source:Lorg/drinkless/tdlib/TdApi$MessageSource;

    .line 46414
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$ViewMessages;->forceRead:Z

    .line 46415
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46419
    const v0, 0x393c0c70

    return v0
.end method
