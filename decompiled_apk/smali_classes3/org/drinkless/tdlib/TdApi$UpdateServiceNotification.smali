.class public Lorg/drinkless/tdlib/TdApi$UpdateServiceNotification;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateServiceNotification"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4e9895ad


# instance fields
.field public content:Lorg/drinkless/tdlib/TdApi$MessageContent;

.field public type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34888
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34889
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$MessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "messageContent"    # Lorg/drinkless/tdlib/TdApi$MessageContent;

    .line 34878
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34879
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateServiceNotification;->type:Ljava/lang/String;

    .line 34880
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateServiceNotification;->content:Lorg/drinkless/tdlib/TdApi$MessageContent;

    .line 34881
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34885
    const v0, 0x4e9895ad

    return v0
.end method
