.class public Lorg/drinkless/tdlib/TdApi$UpdateBusinessMessageEdited;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateBusinessMessageEdited"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7e599277


# instance fields
.field public connectionId:Ljava/lang/String;

.field public message:Lorg/drinkless/tdlib/TdApi$BusinessMessage;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33828
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33829
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$BusinessMessage;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "businessMessage"    # Lorg/drinkless/tdlib/TdApi$BusinessMessage;

    .line 33818
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33819
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateBusinessMessageEdited;->connectionId:Ljava/lang/String;

    .line 33820
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateBusinessMessageEdited;->message:Lorg/drinkless/tdlib/TdApi$BusinessMessage;

    .line 33821
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33825
    const v0, -0x7e599277

    return v0
.end method
