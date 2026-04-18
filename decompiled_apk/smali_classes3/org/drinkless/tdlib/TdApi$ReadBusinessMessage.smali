.class public Lorg/drinkless/tdlib/TdApi$ReadBusinessMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReadBusinessMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x66bb0112


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39338
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39339
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J

    .line 39327
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39328
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReadBusinessMessage;->businessConnectionId:Ljava/lang/String;

    .line 39329
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$ReadBusinessMessage;->chatId:J

    .line 39330
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$ReadBusinessMessage;->messageId:J

    .line 39331
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39335
    const v0, -0x66bb0112

    return v0
.end method
