.class public Lorg/drinkless/tdlib/TdApi$Usernames;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Usernames"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2fa90ef5


# instance fields
.field public activeUsernames:[Ljava/lang/String;

.field public disabledUsernames:[Ljava/lang/String;

.field public editableUsername:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42044
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42045
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "strArr"    # [Ljava/lang/String;
    .param p2, "strArr2"    # [Ljava/lang/String;
    .param p3, "str"    # Ljava/lang/String;

    .line 42033
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42034
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Usernames;->activeUsernames:[Ljava/lang/String;

    .line 42035
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$Usernames;->disabledUsernames:[Ljava/lang/String;

    .line 42036
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$Usernames;->editableUsername:Ljava/lang/String;

    .line 42037
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42041
    const v0, 0x2fa90ef5

    return v0
.end method
