.class public Lorg/drinkless/tdlib/TdApi$SaveApplicationLogEvent;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SaveApplicationLogEvent"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x30593df2


# instance fields
.field public chatId:J

.field public data:Lorg/drinkless/tdlib/TdApi$JsonValue;

.field public type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39734
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39735
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JLorg/drinkless/tdlib/TdApi$JsonValue;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "jsonValue"    # Lorg/drinkless/tdlib/TdApi$JsonValue;

    .line 39723
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39724
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SaveApplicationLogEvent;->type:Ljava/lang/String;

    .line 39725
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$SaveApplicationLogEvent;->chatId:J

    .line 39726
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SaveApplicationLogEvent;->data:Lorg/drinkless/tdlib/TdApi$JsonValue;

    .line 39727
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39731
    const v0, -0x30593df2

    return v0
.end method
