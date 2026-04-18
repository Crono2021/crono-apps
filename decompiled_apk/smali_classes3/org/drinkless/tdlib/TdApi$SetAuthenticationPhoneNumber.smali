.class public Lorg/drinkless/tdlib/TdApi$SetAuthenticationPhoneNumber;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetAuthenticationPhoneNumber"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x33c0d823


# instance fields
.field public phoneNumber:Ljava/lang/String;

.field public settings:Lorg/drinkless/tdlib/TdApi$PhoneNumberAuthenticationSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30968
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30969
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$PhoneNumberAuthenticationSettings;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "phoneNumberAuthenticationSettings"    # Lorg/drinkless/tdlib/TdApi$PhoneNumberAuthenticationSettings;

    .line 30958
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30959
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetAuthenticationPhoneNumber;->phoneNumber:Ljava/lang/String;

    .line 30960
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetAuthenticationPhoneNumber;->settings:Lorg/drinkless/tdlib/TdApi$PhoneNumberAuthenticationSettings;

    .line 30961
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30965
    const v0, 0x33c0d823

    return v0
.end method
