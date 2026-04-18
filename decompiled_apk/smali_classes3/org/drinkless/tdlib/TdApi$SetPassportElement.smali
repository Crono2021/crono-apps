.class public Lorg/drinkless/tdlib/TdApi$SetPassportElement;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetPassportElement"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PassportElement;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7b45d19c


# instance fields
.field public element:Lorg/drinkless/tdlib/TdApi$InputPassportElement;

.field public password:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31668
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31669
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputPassportElement;Ljava/lang/String;)V
    .locals 0
    .param p1, "inputPassportElement"    # Lorg/drinkless/tdlib/TdApi$InputPassportElement;
    .param p2, "str"    # Ljava/lang/String;

    .line 31658
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31659
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetPassportElement;->element:Lorg/drinkless/tdlib/TdApi$InputPassportElement;

    .line 31660
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetPassportElement;->password:Ljava/lang/String;

    .line 31661
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31665
    const v0, 0x7b45d19c

    return v0
.end method
