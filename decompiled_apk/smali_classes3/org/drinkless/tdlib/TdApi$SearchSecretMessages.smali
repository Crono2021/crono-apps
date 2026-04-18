.class public Lorg/drinkless/tdlib/TdApi$SearchSecretMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchSecretMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundMessages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x32d5b364


# instance fields
.field public chatId:J

.field public filter:Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;

.field public limit:I

.field public offset:Ljava/lang/String;

.field public query:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48580
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48581
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;ILorg/drinkless/tdlib/TdApi$SearchMessagesFilter;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "i9"    # I
    .param p6, "searchMessagesFilter"    # Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;

    .line 48567
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48568
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SearchSecretMessages;->chatId:J

    .line 48569
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SearchSecretMessages;->query:Ljava/lang/String;

    .line 48570
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SearchSecretMessages;->offset:Ljava/lang/String;

    .line 48571
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$SearchSecretMessages;->limit:I

    .line 48572
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$SearchSecretMessages;->filter:Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;

    .line 48573
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48577
    const v0, -0x32d5b364

    return v0
.end method
